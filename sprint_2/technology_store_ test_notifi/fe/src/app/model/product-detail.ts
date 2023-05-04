import {Product} from './product';
import {Image} from './image';

export interface ProductDetail {
  product?: Product;
  imageList: Image[];
}
