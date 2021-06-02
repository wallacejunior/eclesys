import { HELP_DESK_API } from './helpdesk.api';
import {Usuario} from './../model/usuario.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) {

  }

  login(usuario: Usuario){
    return this.http.post(`${HELP_DESK_API}/api/auth`, usuario);
  }

  creatOrUpdate(usuario: Usuario){
    if(usuario.id != null && usuario.id != ''){
      return this.http.put(`${HELP_DESK_API}/api/user`, usuario);
    } else {
      usuario.id = null;
      return this.http.post(`${HELP_DESK_API}/api/user`, usuario);
    }
  }
}
