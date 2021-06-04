import { Router } from '@angular/router';
import { SharedService } from 'src/app/services/shared.service';
import { CurrentUser } from '../../../model/current-user.model';
import { UsuarioService } from './../../../Services/usuario.service';
import { User } from '../../../model/user.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User('','','','');
  shared : SharedService;
  message: string;
  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) { 
    this.shared = SharedService.getInstance();
  }

  ngOnInit() {
  }

  login(){
    this.message = '';
    this.usuarioService.login(this.user).subscribe((usuarioAuthentication: CurrentUser) => {
      this.shared.token = usuarioAuthentication.token;
      this.shared.user = usuarioAuthentication.user;
      this.shared.user.profile = this.shared.user.profile.substring(5);
      this.shared.showTemplate.emit(true);
      this.router.navigate(['/']);
    },err => {
      this.shared.token = null;
      this.shared.user = null;
      this.shared.showTemplate.emit(false);
      this.message = 'Erro';
    });
    
  }

  cancelLogin(){
    this.message = '';
    this.user = new User('','','','');
    window.location.href = '/login';
    window.location.reload();
  }
}
