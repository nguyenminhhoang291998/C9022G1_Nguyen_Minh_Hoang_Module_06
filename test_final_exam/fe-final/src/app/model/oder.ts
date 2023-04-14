import {Customer} from './customer';

export interface Oder {
  id?: number;
  customer?: Customer;
  oderDate?: string;
  totalPrice?: number;
}
