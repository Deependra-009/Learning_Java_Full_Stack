export interface ContactRequestBean{
    name:string;
    phoneNumber:string;
}

export interface ContactResponseBean extends ContactRequestBean{
    id:number;
}