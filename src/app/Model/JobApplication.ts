import { User } from './User';

export class JobApplication{
    id?:number;
    user: User = new User();
    jobTitle?:string;
    jobId?:number;
    status?:string;
    appliedDate?:Date;
    cvFile?:string;
    comment?:string;
}