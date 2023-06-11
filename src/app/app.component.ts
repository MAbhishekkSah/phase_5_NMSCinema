import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'NMSCinema';

  loggedUser:any;
  isAdminLoggedIn():string{
    return 'N';
  }
  
  isUserLoggedIn():string {
    return 'N';
  }
}
