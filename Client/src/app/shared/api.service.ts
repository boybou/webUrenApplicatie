import {Injectable} from "@angular/core";
import {AuthorisationService} from "./authorisation.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable()
export class ApiService {
  constructor(private http: HttpClient) {

  }

  public get<Any>(uri: string) {
    let header = AuthorisationService.header;
    return this.http.get<Any>(uri, {headers: header});


  }

  public post<Any>(uri: string,data: Object) {
    let header = AuthorisationService.header;
    return this.http.post(uri,data, {headers: header});
  }
}


