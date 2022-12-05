export class HCOUser{

    constructor(
        public hcoId:number,
        public userId:number,
        public organizationName:string,
        public address:string,
        public country:string,
        public state:string,
        public city:string,
        public zipcode:string,
        public email:string,
        public website:string,
        public primaryContact:string,
        public primaryContactMobile:string,
        public secondaryContact:string,
        public secondaryContactMobile:string,
        public programs:string,
        public status:string
    ){}
    }