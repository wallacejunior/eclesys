import { SharedService } from './../../services/shared.service';
import { Membro } from './../../model/membro.model';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ResponseApi } from 'src/app/model/response-api';

@Component({
  selector: 'app-membro-new',
  templateUrl: './membro-new.component.html',
  styleUrls: ['./membro-new.component.css']
})
export class MembroNewComponent implements OnInit {

  @ViewChild('form',{static: false}) form: NgForm;
  membro = new Membro('','','','','','','','','', null);
  shared : SharedService;
  message : {};
  classCss: {};

  constructor(private membroService,
    private route: ActivatedRoute ) { 
      this.shared = SharedService.instance;
    }

  ngOnInit() {
    let id: string = this.route.snapshot.params['id'];
    if(id != undefined){
      this.findById(id);
    }
  }

  register(){
    this.message = {};
    this.membroService.save(this.membro).subscribe((responseApi: ResponseApi) =>{
      this.membro = new Membro('','','','','','','','','',null);
      let membroRet : Membro = responseApi.data;
      this.form.resetForm();
      this.showMessage({
        type: 'success',
        text: `Registered ${membroRet.nome} sucessfully`
      });
    }, err =>{
      this.showMessage({
        type: 'error',
        text: err['error']['erros'][0]
        });
    });
  }

  findByNome(nome:String){
    this.membroService.findByNome(nome).subscribe((responseApi: ResponseApi) => {
      this.membro = responseApi.data;
    },err => {
        this.showMessage({
        type: 'error',
        text: err['error']['erros'][0]
        });
      });
  }

  findById(id:String){
    this.membroService.findById(id).subscribe((responseApi: ResponseApi) => {
      this.membro = responseApi.data;
    },err => {
        this.showMessage({
        type: 'error',
        text: err['error']['erros'][0]
        });
      });
  }


  private showMessage(message:{type: string, text: string}): void{
    this.message = message;
    this.buildClasses(message.type);
    setTimeout(() => {
      this.message = undefined;
    }, 3000);
  } 
  private buildClasses(type: string): void{
    this.classCss = {
      'alert': true
    }
    this.classCss['alert-'+type] = true;
  }
}
