import {Brands} from './brands';
import {ProductType} from './product-type';

export interface Product {
  id?: number;
  name?: string;
  price?: number;
  description?: string;
  releaseDate?: string;
  productQuantity?: number;
  productTypeName?: string;
  brandsName?: string;
  url?: string;
}
