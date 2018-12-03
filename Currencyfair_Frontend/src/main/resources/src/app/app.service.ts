import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import { Cookie } from 'ng2-cookies';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
 
export class TradeTransaction {
  constructor(
    public userId: string,
    public currencyFrom: string,
    public currencyTo: string,
    public amountSell: number,
    public amountBuy: number,
    public rate: number,
    public timePlaced  :string,
    public originatingCountry : string) { }
} 

@Injectable()
export class AppService {
  constructor(
    private _router: Router, private _http: Http){}
 
  obtainAccessToken(loginData){
    let params = new URLSearchParams();
    params.append('username',loginData.username);
    params.append('password',loginData.password);    
    params.append('grant_type','password');
    params.append('client_id','testjwtclientid');

    let headers = new Headers({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Basic '+btoa("testjwtclientid:XY7kmzoNzl100")});
    let options = new RequestOptions({ headers: headers });
    console.log(params.toString());
     this._http.post('http://localhost:8080/currencyfair/oauth/token', params.toString(), options)
    .map(res => res.json())
    .subscribe(
      data => this.saveToken(data),
      err => alert('Invalid Credentials')
    ); 
  }


  saveToken(token){
    var expireDate = new Date().getTime() + (1000 * token.expires_in);
    Cookie.set("access_token", token.access_token, expireDate);
    console.log('Obtained Access token');
    this._router.navigate(['/']);
  }

  getResource(resourceUrl) : Observable<Array<TradeTransaction>>{
    var headers = new Headers({'Content-type': 'application/json', 'Accept' : 'application/json', 'Authorization': 'Bearer '+Cookie.get('access_token')});
    var options = new RequestOptions({ headers: headers });
    return this._http.get(resourceUrl, options)
                   .map((res:Response) => res.json())
                   .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  checkCredentials(){
    if (!Cookie.check('access_token')){
        this._router.navigate(['/login']);
    }
  } 

  logout() {
    Cookie.delete('access_token');
    this._router.navigate(['/login']);
  }
}
