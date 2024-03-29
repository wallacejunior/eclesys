import { SharedService } from 'src/app/services/shared.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  showTemplate: boolean = false;
  public shared: SharedService;
  title = 'eclesysView';

  constructor(){
    this.shared = SharedService.getInstance();

  }
  ngOnInit(){
    this.shared.showTemplate.subscribe(
      show => this.showTemplate = show
    );
  }

  showContentWrapper(){
    return{
      'content-wrapper' : this.shared.isLoggedIn()
    };
  }
}
