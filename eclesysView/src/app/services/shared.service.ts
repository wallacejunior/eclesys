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

  constructor() { }
}
