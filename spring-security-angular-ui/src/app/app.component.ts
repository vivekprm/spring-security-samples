import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Spring security with angular demo';
  authenticated = false;
  greeting: any = {
    id: '',
    content: ''
  };
  credentials: any = {
    username: '',
    password: ''
  };

  constructor(private http: HttpClient, private router: Router) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With':  'XMLHttpRequest'
      })
    };
    http.get('api/greeting', httpOptions).subscribe(data => this.greeting = data);
  }
  login() {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With':  'XMLHttpRequest',
        authorization: 'Basic '
              + btoa(this.credentials.username + ':' + this.credentials.password)
      })
    };
    this.http.get('api/greeting', httpOptions).subscribe((response) => {
      this.greeting = response;
      this.authenticated = true;
    });
  }
  logout() {
    this.http.post('logout', {}).subscribe(() => {
        this.authenticated = false;
        this.router.navigateByUrl('/');
    });
  }
}
