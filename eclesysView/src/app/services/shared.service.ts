import { Injectable } from '@angular/core';
import { EventEmitter } from 'events';
import {Usuario} from './../model/usuario.model'

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  public static instance : SharedService = null;
  user: Usuario;
  token: string;
  showTemplate = new EventEmitter();

  constructor() {
    return SharedService.instance = SharedService.instance || this;
   }

   public static getInstance(){
     if(this.instance == null){
        this.instance = new SharedService();
     }
     return this.instance;
   }

   isLoggedIn():boolean{
     if(this.user == null){
       return false;
     }
     return this.user.email != '';
   }
}
