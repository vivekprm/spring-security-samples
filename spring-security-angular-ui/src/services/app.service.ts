import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AppService {
  authenticated = false;
  constructor(private http: HttpClient) {
  }

  authenticate(credentials, callback) {
    const httpOptions = credentials ? {headers: new HttpHeaders({
      'X-Requested-With': 'XMLHttpRequest',
      authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    })} : {headers: new HttpHeaders({'X-Requested-With': 'XMLHttpRequest'})};

    this.http.get('api/greeting', httpOptions).subscribe(response => {
        if (response['id']) {
            this.authenticated = true;
        } else {
            this.authenticated = false;
        }
        return callback && callback();
    });

  }

}
