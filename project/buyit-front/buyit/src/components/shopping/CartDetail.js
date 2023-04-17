import React, { useState, useEffect, useRef } from "react";
import { useNavigate } from "react-router-dom";
import { Button } from "primereact/button";
import { DataView } from "primereact/dataview";
import { Toast } from "primereact/toast";
import "primeflex/primeflex.css";
import axios from "axios";

export default function CartDetail() {
  let navigate = useNavigate();
  const toast = useRef(null);
  const baseImgPath = "../../../img/";
  const [cart, setCart] = useState({});
  const [isUpdated, setIsUpdated] = useState(false);
  const url = "http://localhost:8080/cart/get/1";

  useEffect(() => {
    axios.get(url).then((response) => {
      setCart(response.data);
    });
  }, [isUpdated]);

  const removeFromCart = (product) => {
    const url = "http://localhost:8080/cart/remove/1/" + product.productId;
    axios.delete(url).then((response) => {
      setIsUpdated(!isUpdated);
      if (response.status === 200) {
        toast.current.show({
          severity: "success",
          summary: "Success",
          detail: "The product removed from cart.",
          life: 3000,
        });
      } else {
        toast.current.show({
          severity: "error",
          summary: "Error",
          detail: "The product could not be removed from the cart.",
          life: 3000,
        });
      }
    });
  };

  const itemTemplate = (product) => {
    return (
      <div className="col-12">
        <div className="flex flex-column xl:flex-row xl:align-items-start p-4 gap-4">
          <img
            className="w-9 sm:w-10rem xl:w-4rem shadow-2 block xl:block mx-auto border-round"
            src={baseImgPath + product.imgPath}
            alt={product.productName}
          />
          <div className="flex flex-column sm:flex-row justify-content-between align-items-center xl:align-items-start flex-1 gap-4">
            <div className="flex flex-column align-items-center sm:align-items-start gap-3">
              <div className="text-2xl font-bold text-900">
                {product.productName}
              </div>
              <div className="flex align-items-center gap-3">
                <span className="flex align-items-center gap-2">
                  <span className="font-semibold">
                    Price: {product.salesPrice.toFixed(2)}
                    <br></br>
                    <br></br>
                    Quantity: {product.cartList[0].salesQuantity}
                  </span>
                </span>
              </div>
            </div>
            <div className="flex sm:flex-column align-items-center sm:align-items-end gap-3 sm:gap-2">
              <span className="text-2xl font-semibold">
                Total: $
                {(
                  product.salesPrice * product.cartList[0].salesQuantity
                ).toFixed(2)}
              </span>
              <Button
                icon="pi pi-trash"
                className="p-button-rounded"
                severity="danger"
                onClick={() => removeFromCart(product)}
              ></Button>
            </div>
          </div>
        </div>
      </div>
    );
  };

  return (
    <>
      <div className="cart-product-list">
        <Toast ref={toast}></Toast>
        <DataView value={cart.products} itemTemplate={itemTemplate} />
      </div>
      <div className="cart-checkout-button">
        <Button
          label="Checkout"
          severity="info"
          className="checkout-button"
          onClick={() => navigate("/checkout")}
        ></Button>
      </div>
    </>
  );
}
