package br.com.bieniek.payment.adapters.out;

import br.com.bieniek.payment.application.core.domain.Sale;
import br.com.bieniek.payment.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {

    private Sale sale;

    private SaleEvent event;

}
