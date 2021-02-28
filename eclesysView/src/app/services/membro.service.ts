import { HELP_DESK_API } from './helpdesk.api';
import {Membro} from './../model/membro.model'
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class MembroService {

  constructor(private http: HttpClient) { }

    
  save(membro: Membro){
    return this.http.post(`${HELP_DESK_API}/membro/`,membro);
  }

  findAll(){
    return this.http.get(`${HELP_DESK_API}/membro/`);
  }

  findByNome(nome: string){
    return this.http.get(`${HELP_DESK_API}/membro/nome/${nome}`);
  }

  delete(id: string){
    return this.http.delete(`${HELP_DESK_API}/membro/`)
  }
}

