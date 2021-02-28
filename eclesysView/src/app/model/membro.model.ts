import { Endereco } from "./endereco.model";

export class Membro{

    constructor(public id: string,
        public nome: string,
        public nascimento: string,
        public fone: string,
        public email: string,
        public sexo: string,
        public cpf: string,
        public estadoCivil: string,
        public Situacao: string,
        public endereco: Endereco){
        

    }
}