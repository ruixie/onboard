/**
 * Created by Nettle on 2015/7/8.
 */

angular.module('onboard').requires.push('tabSample');
angular.module('tabSample', ['plugin'])
    .run(['pluginService', function(pluginService) {
        pluginService.registerTab({
            name: 'tabSample',
            title: '样例TAB',
            templateUrl: 'tabSample.html'
        })
    }]).
    controller('tabSampleCtrl', []);