angular.module('gateway', []).config(function($httpProvider) {
    $httpProvider.defaults.headers.common["X-Requested-With"] = "XMLHttpRequest";
}).controller('navigation', function($http) {
    var self = this;
    var authenticate = function(credentials, callback) {
        var headers = credentials ? {
            authorization : "Basic "
                + btoa(credentials.username + ":"
                    + credentials.password)
        } : {};

        $http.get('user', {
            headers : headers
        }).then(function(response) {
            if (response.data.name) {
                self.authenticated = true;
                self.user = response.data.name;
            } else {
                self.authenticated = false;
            }
            callback && callback();
        }, function() {
            self.authenticated = false;
            callback && callback();
        });
    };

    authenticate();

    self.credentials = {};

    self.login = function() {
        authenticate(self.credentials, function() {
            if (self.authenticated) {
                console.log("Login succeeded")
                self.error = false;
                self.authenticated = true;
            } else {
                console.log("Login failed")
                self.error = true;
                self.authenticated = false;
            }
        })
    };

    // We need CSRF because we are using http post.
    self.logout = function () {
        $http.post("/logout").then(function() {
            self.authenticated = false;
        });
    }
});