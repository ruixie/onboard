/**
 * Created by Nettle on 2015/7/7.
 */

angular.module('onboard').requires.push('companyPluginSample');
angular.module('companyPluginSample', ['plugin'])
    .run(['pluginService', function(pluginService) {
        pluginService.registerCompanyPlugin({
            title: '团队层-样例插件',
            'ui-sref': 'companyPluginSample'
        });
    }])
    .config(['$stateProvider',
        function($stateProvider) {
            $stateProvider
                .state('companyPluginSample', {
                    url        : '/companyPluginSample',
                    views: {
                        'nav'    : {
                            templateUrl: 'onboard-header.html'
                        },
                        'content': {
                            template: '<div>团队层-样例插件</div>'
                        }
                    }
                })
        }
    ]);