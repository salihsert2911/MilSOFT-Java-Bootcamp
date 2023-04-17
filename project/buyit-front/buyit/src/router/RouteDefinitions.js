import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import CategoriesComponent from "../components/inventory/CategoriesComponent";
import ProductComponent from "../components/inventory/ProductComponent";
import ProductsComponent from "../components/inventory/ProductsComponent";
import CartDetail from "../components/shopping/CartDetail";
import CartCheckout from "../components/shopping/CartCheckout";

export const RouteDefinitions = () => {
  return (
    <BrowserRouter>
      <div className="categories">
        <CategoriesComponent></CategoriesComponent>
      </div>
      <div className="router">
        <Routes>
          <Route>
            <Route index element={<ProductsComponent />} />
            <Route path="products/:id" element={<ProductsComponent />} />
            <Route path="product/:id" element={<ProductComponent />} />
            <Route path="cart" element={<CartDetail />} />
            <Route path="checkout" element={<CartCheckout />} />
          </Route>
        </Routes>
      </div>
    </BrowserRouter>
  );
};
