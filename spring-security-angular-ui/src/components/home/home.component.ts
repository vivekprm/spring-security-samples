import { Component, OnInit } from '@angular/core';
import { AppService } from '../../services/app.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  templateUrl: './home.component.html'
})
export class HomeComponent {

  title = 'Demo';
  greeting: any = {
    id: '',
    content: ''
  };

  constructor(private app: AppService, private http: HttpClient) {
    const httpOptions = {headers: new HttpHeaders({
      'X-Requested-With': 'XMLHttpRequest'
    })};
    http.get('api/greeting', httpOptions).subscribe(data => this.greeting = data);
  }
  authenticated() {
    return this.app.authenticated;
  }
}
