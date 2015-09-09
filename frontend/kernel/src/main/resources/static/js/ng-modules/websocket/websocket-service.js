
// todo：是否可以考虑和另一个websocketService合并？现行的获取和分派的职责分离会带来好处吗？

angular.module('websocket')
    .service('websocket', ['webSocketService', function (webSocketService) {
        var enabled = $.support.websocket = window.WebSocket && true;
        this.connection = {};
        var _websocket = this;

        if (enabled) {
             this.sendMessage = function(message) {
                if( _websocket.connection != null ) {
                    //console.log(message);
                    _websocket.connection.send( typeof message === "string" ? message : JSON.stringify(message) );
                }
             };
             this.createWebsocketConnection = function() {
                 var _protocol = location.host == 'onboard.cn' || location.host == '162.105.30.60:10443' ? 'wss://' : 'ws://';
                 _websocket.connection = new WebSocket(encodeURI(_protocol + location.host + '/websocket'));
                 _websocket.connection.onopen = function(event) {
                    console.log('websocket connection opened');
                    $.support.websocket = true && $.support.websocket;
                    _websocket.sendMessage(location.href);
                };
                _websocket.connection.onerror = function(event) {
                    console.error('websocket error');
                };
                _websocket.connection.onclose = function(event) {
                    console.log('websocket connection closed:' + event.code);
                    $.support.websocket = false && $.support.websocket;
                    if(event.code == 1006) return;
                    console.log('try to reconnect...');
                    _websocket.createWebsocketConnection();
                };
                this.connection.onmessage = function(message) {
                    console.log(message.data);
                    webSocketService.activityHandler(eval("(" + message.data + ")"));
                };
            };
        }else{
            this.createWebsocketConnection = function() {};
            this.sendMessage = function(message) {};
        }
        
        this.init = function(){
            this.createWebsocketConnection();
        };
    }]);