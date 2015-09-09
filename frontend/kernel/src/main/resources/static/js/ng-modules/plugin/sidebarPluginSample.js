/**
 * Created by Nettle on 2015/7/8.
 */

angular.module('onboard').requires.push('sidebarPluginSample');
angular.module('sidebarPluginSample', ['plugin'])
    .run(['pluginService', function(pluginService) {
        pluginService.registerSidePlugin({
            icon: 'fa-plug',
            title: '项目插件',
            'ui-sref': '.sidebarPluginSample'
        });
    }])
    .config(['$stateProvider',
        function($stateProvider) {
            $stateProvider
                .state('company.project.sidebarPluginSample', {
                    url        : '/sidebarPluginSample',
                    template: '<div>项目内-样例插件</div>'
                })
        }
    ]);
