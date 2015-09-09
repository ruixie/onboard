angular.module('upload')
    .controller("fileDropZoneCtrl", ['$scope', '$http', '$upload', 'url','uploadsService',
        function($scope, $http, $upload, url, uploadsService) {
            //展示上传附件数组
            $scope.files = [];
            $scope.selectfile = function($files) {
                var tempfile;
                uploadsService.updateAllAttachmentsSize();
                var fileCapacitySize = uploadsService.getAttachmentsSize();
                for (var i = 0; i < $files.length; i++) {
                    if ($files[i].size >= 32000000) {
                        $scope.stat = 'error';
                        $scope.msg = $files[i].name+'上传失败：上传文件过大！';
                        $scope.splice($scope.files.indexOf($files[i]), 1);
                        break;
                    }
                    if($files[i].size + fileCapacitySize.value > 1000000000 || fileCapacitySize.value >= 1000000000){
                        $scope.stat = 'error';
                        $scope.msg = '上传文件总量已达到上限！';
                        $scope.splice($scope.files.indexOf($files[i]), 1);
                        break;
                    }
                    //var upload = $files[i];
                    //$scope.files.push($files[i]);
                    tempfile = $files[i];
                    $scope.upload = $upload.upload({
                        url: url.projectApiUrl() + '/attachments/stage',
                        file: tempfile
                    }).progress(function(e) {
                        //show loadprogressbar
                        $("#attach-Progress").show();
                        $scope.dynamic = parseInt(100.0 * e.loaded /
                        e.total);
                        //                   console.log('percent: ' + parseInt(100.0 * e.loaded /
                        //                   e.total));
                    }).success(function(data, status, headers, config) {

                        $scope.data = data;
                        $scope.stat = 'success';
                        $scope.msg = '上传成功！';
                        //hide loadprogressbar
                        $("#attach-Progress").hide();
                        //$scope.files[$scope.files.indexOf(upload)].id = data.id;
                        $scope.files.push(data);
                        $scope.attachments.push({id: data.id});
                    }).error(function(data, status, headers, config) {
                        $scope.stat = 'error';
                        $scope.msg = '上传失败：' + data;
                    })
                }
            };
            //响应disscussion按钮，清空fileDropZone
            $scope.$on("discussionHideAttachment", function() {
                $scope.files = [];
            });
            $scope.remove = function(file) {
                $http.delete(url.projectApiUrl() + "/attachments/" + file.id).success(function(data) {
                    $scope.files.splice($scope.files.indexOf(file), 1);
                }).error(function(data) {
                    console.log(data);
                });

            };
            //响应disscussion按钮，添加fileDropZone
            $scope.$on('addFiles', function(event, data) {
                //console.log($scope.attachments);
                $scope.files = data;
                for (var key in data) {
                    $scope.attachments.push({
                        id: data[key].id
                    });
                }
                //console.log("After adding files");
                //console.log($scope.attachments);
            });


        }]);