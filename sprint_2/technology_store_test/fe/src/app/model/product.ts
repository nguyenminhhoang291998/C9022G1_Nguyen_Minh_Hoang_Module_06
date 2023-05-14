import {ProductType} from './product-type';
import {Brands} from './brands';

export interface Product {
  id?: number;
  name?: string;
  price?: number;
  description?: string;
  releaseDate?: string;
  productQuantity?: number;
  productType?: ProductType;
  brands?: Brands;
}
