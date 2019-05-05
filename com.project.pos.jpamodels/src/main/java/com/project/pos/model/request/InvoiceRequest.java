package com.project.pos.model.request;

import com.project.pos.model.types.InvType;
import com.project.pos.model.Invoicereg;
import com.project.pos.model.types.PayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequest {

    private List<Invoicereg> invoiceregList;

    private InvType invtype;

    private double paid;

    private PayType paytype;

    private double remain;

    private double total;

    private int customer;

}
