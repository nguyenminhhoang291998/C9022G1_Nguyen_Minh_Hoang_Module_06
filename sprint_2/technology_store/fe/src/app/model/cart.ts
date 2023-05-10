export interface Cart {
  id?: number;
  datePurchase?: string;
  orderCode?: string;
  orderedQuantity?: number;
  productName?: string;
  productId?: number;
  productQuantity?: number;
  productPrice?: number;
  totalQuantity?: number;
  totalPrice?: number;
  url?: string;
  orderDetailId?: number;
}
