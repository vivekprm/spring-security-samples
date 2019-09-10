import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Spring security with angular demo';
  greeting = {};
  constructor(private http: HttpClient) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With':  'XMLHttpRequest'
      })
    };
    http.get('api/greeting', httpOptions).subscribe(data => this.greeting = data);
  }
}
