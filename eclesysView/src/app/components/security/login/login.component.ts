import { Usuario } from './../../../model/usuario.model';
import { Component, OnInit } from '@angular/core';
import { SharedService } from 'src/app/services/shared.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  Usuario = new Usuario('','','','','','','','');
  shared : SharedService;
  message: string;
  constructor() { }

  ngOnInit() {
  }

}
