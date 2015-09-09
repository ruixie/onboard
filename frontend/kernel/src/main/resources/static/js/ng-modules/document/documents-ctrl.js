/************************** projectApp angular module **************************/
    // 任务子页面
angular.module('documents')
    .config(['$stateProvider',
        function($stateProvider) {
            $stateProvider
                .state('company.project.documents', {
                    url        : '/documents',
                    templateUrl: 'documents.html',
                    controller : 'documentsCtrl'
                })
                .state('company.project.documents.newTXTDocument', {
                    url        : '/new/txt',
                    templateUrl: 'newTXTDocument.html',
                    controller : 'newTXTDocumentCtrl'
                })
                .state('company.project.documents.newMarkdownDocument', {
                    url        : '/new/markdown',
                    templateUrl: 'newMarkdownDocument.html',
                    controller : 'newMarkdownDocumentCtrl'
                })
                .state('company.project.documents.newHTMLDocument', {
                    url        : '/new/html',
                    templateUrl: 'newHTMLDocument.html',
                    controller : 'newHTMLDocumentCtrl'
                })
                .state('company.project.documents.documentDetails', {
                    url        : '/{docId:[0-9]+}',
                    templateUrl: 'documentDetails.html',
                    controller : 'documentDetailsCtrl'
                })
                .state('company.project.documents.documentDetails.edit', {
                    url        : '/edit',
                    templateUrl: 'documentDetailsEdit.html',
                    controller : 'documentDetailsEditCtrl'
                })
                .state('company.project.documents.documentDetails.history', {
                    url        : '/{version}',
                    templateUrl: 'documentHistory.html',
                    controller : 'documentDetailsHistoryCtrl'
                })
        }
    ])
    .controller('documentsCtrl', ['$scope', '$state', '$sce', 'documentService',
        function($scope, $state, $sce, documentService) {
            $scope.companyId = $state.params.companyId;
            $scope.projectId = $state.params.projectId;

            $scope.predicate = 'updated';
            $scope.reverse = true;
            $scope.busy = false;

            $scope.toggleNewDocDropdown = function($event) {
                $($event.target).dropdown('toggle');
            };

            /* --------- Init the wiki list  ---------------*/
            $scope.refreshDocuments = function() {

                documentService.initDocumentsList($scope.projectId, $scope.companyId).then(function(data) {
                    $scope.documents = data.documents;
                    $scope.latestDocuments = data.latestDocuments;
                    $scope.totalDocCounts = documentService.getDocsCount();
                    pagination();
                }, function(error) {
                    console.log('error happens when fetching documents data!');
                });
            };
            $scope.refreshDocuments();

            $scope.hasNext = function() {
                return ($scope.documents && $scope.totalDocCounts && ($scope.documents.length < $scope.totalDocCounts));
            };

            $scope.displayNoMorePage = function() {
                return ($scope.documents && $scope.documents.length > 15 && !$scope.hasNext());
            };

            $scope.addMoreDocuments = function() {
                if($scope.hasNext() && $scope.busy === false) {
                    $scope.busy = true;
                    documentService.getDocumentsByStartNum($scope.documents.length, $scope.projectId, $scope.companyId).then(function(data) {
                        console.log("documents size is " + $scope.documents.length);
                        console.log("total documents size is " + $scope.totalDocCounts);
                        $scope.busy = false;
                        pagination();
                    });
                }
            };

            var pagination = function() {
                // 自己实现的分页
                var $page = $('#documents .document-content-wrapper');
                var $pageContainer = $page.scrollParent();
                var margin = 50;
                var scrollTrigger = 0.95;
                var scrollFun = function() {
                    var wintop = $pageContainer.scrollTop(),
                        docheight = $page.height(),
                        winheight = $pageContainer.height(),
                        _trigger = wintop / (docheight - winheight + margin);

                    if(_trigger > scrollTrigger) {
                        if($scope.busy === false) {
                            $scope.addMoreDocuments();
                            $pageContainer.unbind('scroll', scrollFun);
                        }
                    }
                };
                $pageContainer.scroll(scrollFun);
            };

            $scope.wikiTrustDangerousSnippet = function(htmlString) {
                return $sce.trustAsHtml(htmlString);
            };

        }  /* end of controller function */
    ])/* end of controller  */
    .controller('newTXTDocumentCtrl', ['$scope', '$state', 'documentService',
        function($scope, $state, documentService) {

            var windowHeight = document.documentElement.clientHeight - 450;
            if(windowHeight < 100) windowHeight = 100;

            /* -------------- Init new wiki functionality ----------*/
            $scope.newTXTWikiTitle = "";
            $scope.newTXTWikiContent = "";

            $('#newTXTWikiContent').height(windowHeight);

            $scope.saveNewTXTWikiForm = function() {
                documentService.createNewDocument($scope.newTXTWikiTitle, $scope.newTXTWikiContent,
                    [], documentService.docType.TXT.value).then(function(data) {
                        $state.go('company.project.documents.documentDetails', { docId: data.documentDetails.id });
                    }, function(error) {
                        $scope.stat = 'error';
                        $scope.msg = '文档新建失败';
                    });
            };

            $('input[name="title"]').focus();

        }  /* end of controller function */
    ])/* end of controller  */
    .controller('newMarkdownDocumentCtrl', ['$scope', '$state', 'documentService',
        function($scope, $state, documentService) {

            var windowHeight = document.documentElement.clientHeight - 450;
            if(windowHeight < 100) windowHeight = 100;

            $scope.newMarkdownWikiTitle = "";

            var newMarkdownWikiContent = $("#newMarkdownWikiContent");
            newMarkdownWikiContent.height(windowHeight);

            newMarkdownWikiContent.markdown({
                autofocus  : false,
                savable    : false,
                language   : 'zh',
                resize     : 'vertical',
                iconlibrary: 'fa'
            });

            $scope.saveNewMarkdownWikiForm = function() {
                var mdContent = newMarkdownWikiContent.data('markdown').getContent();
                documentService.createNewDocument($scope.newMarkdownWikiTitle, mdContent,
                    [], documentService.docType.MD.value).then(function(data) {
                        $state.go('company.project.documents.documentDetails', { docId: data.documentDetails.id });
                    }, function(error) {
                        $scope.stat = 'error';
                        $scope.msg = '文档新建失败';
                    });
            };

            $('input[name="title"]').focus();

        }  /* end of controller function */
    ])/* end of controller  */
    .controller('newHTMLDocumentCtrl', ['$scope', '$state', 'richtexteditor', 'documentService',
        function($scope, $state, richtexteditor, documentService) {
            $scope.uploadedImageInTextEditor = [];

            var windowHeight = document.documentElement.clientHeight - 450;
            if(windowHeight < 100) windowHeight = 100;
            /*-------------- Init the new wiki text editor ------ */
            richtexteditor.initEditAreaFullTools($('#newHTMLWikiContent'), { height: windowHeight }, $scope.uploadedImageInTextEditor);

            /* -------------- Init new wiki functionality ----------*/
            $scope.newHTMLWikiTitle = "";
            $scope.saveNewHTMLWikiForm = function() {
                var newWikiContent = $('#newHTMLWikiContent').code();
                documentService.createNewDocument($scope.newHTMLWikiTitle, newWikiContent,
                    $scope.uploadedImageInTextEditor, documentService.docType.HTML.value).then(function(data) {
                        $('#newHTMLWikiContent').destroy();
                        $state.go('company.project.documents.documentDetails', { docId: data.documentDetails.id });
                    }, function(error) {
                        $scope.stat = 'error';
                        $scope.msg = '文档新建失败';
                    });
            };

            $scope.newHTMLCreationCancel = function() {
                $('#newHTMLWikiContent').destroy();
                history.back(-1);
            };

            $('input[name="title"]').focus();

        }  /* end of controller function */
    ])/* end of controller  */
    .controller('documentDetailsCtrl', ['$scope', '$state', 'tab', 'documentService', 'collectionService',
        function($scope, $state, tab, documentService, collectionService) {

            /* ---------- Init document data ------------- */
            $scope.documentTabs = [tab.getTabInfo("comment", true), tab.getTabInfo("activity")];
            $scope.docId = $state.params.docId;
            $scope.docTypes = documentService.docType;

            $scope.markdownToHTML = function(markdownContent) {
                if(markdownContent) {
                    return markdown.toHTML(markdownContent);
                }
            };

            $scope.refreshDocumentDetails = function() {
                documentService.getDocumentById($scope.docId).then(function(data) {
                    $scope.documentDetails = data.documentDetails;
                    $scope.documentHistories = data.documentHistories;
                    $scope.$broadcast('updateTab', {
                        attachType: 'document',
                        attachId  : data.documentDetails.id,
                        projectId : data.documentDetails.projectId,
                        companyId : data.documentDetails.companyId
                    });
                }, function(error) {
                    console.log('Error happens when fetching document details!');
                });
            };
            $scope.refreshDocumentDetails();

            $scope.deleteDocument = function() {
                if(confirm("确定要删除该文档及其全部文档历史记录吗？")) {
                    documentService.deleteDocument($scope.documentDetails.id).then(function(data) {
                        $state.go('company.project.documents');
                        console.log("delete wiki success");
                    }, function(error) {
                        console.log("delete wiki failed");
                    });
                }
            }

            // collection
            collectionService.isCollected('document', $scope.docId).then(function(data) {
                if(data.length > 0) {
                    $scope.isCollected = true;
                    $scope.colleInfo = data[0];
                } else {
                    $scope.isCollected = false;
                    $scope.colleInfo = null;
                }
            });

            $scope.collect = function() {
                console.log($scope.isCollected);
                if($scope.isCollected) {
                    collectionService.delCollection($scope.colleInfo.id).then(function(data) {
                        $scope.isCollected = !$scope.isCollected;
                        console.log(data);
                    });
                }
                else {
                    collectionService.addCollection('document', $scope.docId).then(function(data) {
                        $scope.isCollected = !$scope.isCollected;
                        $scope.colleInfo = data;
                        console.log(data);
                    });
                }
            };
        }
    ])
    .controller('documentDetailsEditCtrl', ['$scope', '$state', 'richtexteditor', 'documentService',
        function($scope, $state, richtexteditor, documentService) {
            $scope.documentTabs = [];
            $scope.uploadedImageInTextEditor = [];
            $scope.docId = $state.params.docId;

            var windowHeight = document.documentElement.clientHeight - 450;
            if(windowHeight < 100) windowHeight = 100;

            var wikiDetailsContent = $('#wikiDetailsContentEdit');
            wikiDetailsContent.height(windowHeight);

            var initWikiConetentTextarea = function(docType) {
                if(docType === documentService.docType.HTML.value) {
                    richtexteditor.initEditAreaFullTools(wikiDetailsContent, { height: windowHeight }, $scope.uploadedImageInTextEditor);
                    wikiDetailsContent.code($scope.documentDetails.content);
                } else if(docType === documentService.docType.MD.value) {
                    wikiDetailsContent.markdown({
                        autofocus  : false,
                        savable    : false,
                        language   : 'zh',
                        resize     : 'vertical',
                        iconlibrary: 'fa'
                    });
                    wikiDetailsContent.data('markdown').setContent($scope.documentDetails.content);
                } else if(docType === documentService.docType.TXT.value) {
                    wikiDetailsContent.val($scope.documentDetails.content);
                }
            };

            documentService.getDocumentById($scope.docId).then(function(data) {
                $scope.documentDetails = data.documentDetails;
                $scope.updatedWikiTitle = $scope.documentDetails.title;
                initWikiConetentTextarea($scope.documentDetails.docType);
            }, function(error) {
                console.log('Error happens when fetching document details!');
            });

            var getUpdatedWikiContent = function(docType) {
                var content = "";
                if(docType === documentService.docType.HTML.value) {
                    content = wikiDetailsContent.code();
                } else if(docType === documentService.docType.MD.value) {
                    content = wikiDetailsContent.data('markdown').getContent();
                } else if(docType === documentService.docType.TXT.value) {
                    content = wikiDetailsContent.val();
                }
                return content;
            };

            $scope.savewikiDetailsForm = function() {
                var wikiContent = getUpdatedWikiContent($scope.documentDetails.docType);
                documentService.updateDocument($scope.documentDetails.id, $scope.updatedWikiTitle, wikiContent, $scope.uploadedImageInTextEditor).then(function(data) {
                    $state.go('^', {}, { reload: true });
                    wikiDetailsContent.destroy();
                }, function(error) {
                    wikiDetailsContent.destroy();
                    $scope.stat = 'error';
                    $scope.msg = '文档更新失败';
                });
            };

            $scope.cancelEdit = function() {
                wikiDetailsContent.destroy();
                $state.go('^', {}, { reload: true });
            };

        }  /* end of controller function */
    ])/* end of controller  */
    .controller('documentDetailsHistoryCtrl', ['$scope', '$state', 'documentService',
        function($scope, $state, documentService) {
            $scope.documentTabs = [];
            documentService.getDocumentHistoryInfo($state.params.docId, $state.params.version).then(function(data) {
                $scope.documentHistoryInfo = data.documentHistoryInfo;
            }, function(error) {
                console.log('Error happens when fetching document history info!');
            });
        }
    ])
    .filter('nl2br', ['$sce', function($sce) {
        return function(msg, is_xhtml) {
            var is_xhtml = is_xhtml || true;
            var breakTag = (is_xhtml) ? '<br />' : '<br>';
            var msg = (msg + '').replace(/([^>\r\n]?)(\r\n|\n\r|\r|\n)/g, '$1' + breakTag + '$2');
            return $sce.trustAsHtml(msg);
        }
    }]);

