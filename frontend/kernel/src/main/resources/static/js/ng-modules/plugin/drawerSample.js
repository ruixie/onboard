/**
 * Created by Nettle on 2015/7/8.
 */

angular.module('onboard').requires.push('drawerSample');
angular.module('drawerSample', ['util'])
    .run(['drawer', function(drawer) {
        drawer.registerDrawer({
            name: 'drawerSample',
            template: 'drawerSample.html'
        });
    }]).
    controller('drawerSampleCtrl', ['$scope', 'tab', function($scope, tab) {
        $scope.drawerSampleTabs = [
            tab.getTabInfo("tabSample")
        ];
    }]);
