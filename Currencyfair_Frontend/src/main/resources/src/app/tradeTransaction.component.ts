import { Component } from '@angular/core';
import {AppService, TradeTransaction} from './app.service'

@Component({
  selector: 'foo-details',
  providers: [AppService],  
  template: `<div class="container">
    <h1 class="col-sm-12">Trade Transaction Details</h1>
    <table>
      <tr>
        <th *ngFor="let col of columns">
          {{col}}
        </th>
      </tr>
      <tr *ngFor="let char of tradeTrans">
        <td *ngFor="let col of columns">
          {{char[col]}}
        </td>
      </tr>
    </table>
    <div class="col-sm-12">
      <button class="btn btn-primary" (click)="getTradeTransactions()" type="submit">Fetch all Trade Transactions</button>
    </div>
</div>`
})

export class TradeTransactionComponent {
    public tradeTrans : Array<TradeTransaction> = [];
    public columns: string[] = ["userId", "currencyFrom", "currencyTo", "amountBuy", "amountSell", "rate", "timePlaced", "originatingCountry"];
    private tradeTransUrl = 'http://localhost:8080/currencyfair/tradetrans';

    constructor(private _service:AppService) {
      this.getTradeTransactions()
    }

    getTradeTransactions(){
        this._service.getResource(this.tradeTransUrl)
         .subscribe(
                     data => this.tradeTrans = data);
    }
}
