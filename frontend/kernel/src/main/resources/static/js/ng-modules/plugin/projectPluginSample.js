/**
 * Created by Nettle on 2015/7/7.
 */

angular.module('onboard').requires.push('projectPluginSample');
angular.module('projectPluginSample', ['plugin'])
    .run(['pluginService', function(pluginService) {
        pluginService.registerProjectPlugin({
            title: '项目层-样例插件',
            'ui-sref': '.projectPluginSample'
        });
    }])
    .config(['$stateProvider',
        function($stateProvider) {
            $stateProvider
                .state('company.projectPluginSample', {
                    url        : '/projectPluginSample',
                    template: '<div>项目层-样例插件' +
                        '<div class="btn btn-primary" open-drawer="drawerSample" open-drawer-params="" title="drawerSample">\
                            drawerSample\
                        </div>' +
                    '</div>'
                    //controller: 'bCtrl'
                })
        }
    ]);