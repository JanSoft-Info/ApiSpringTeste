
package br.com.jansoftinfo.apiteste.adapter.out.mappers;

import br.com.jansoftinfo.apiteste.adapter.out.dto.CustomerOutDTO;
import br.com.jansoftinfo.apiteste.adapter.out.dto.SaleOutDTO;
import br.com.jansoftinfo.apiteste.adapter.out.dto.TitleOutDTO;
import br.com.jansoftinfo.apiteste.domain.entities.SaleEntity;
import br.com.jansoftinfo.apiteste.domain.entities.TitleEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaleOutMapper {

    public List<SaleOutDTO> toDTO(List<SaleEntity> entity) {
        var salesDTO = new ArrayList<SaleOutDTO>();
        entity.forEach(sale -> {
            salesDTO.add(getSale(sale));
        });
        return salesDTO;
    }

    public SaleOutDTO toDTO(SaleEntity entity) {
        return getSale(entity);
    }

    private static SaleOutDTO getSale(SaleEntity entity) {
        return SaleOutDTO.builder()
                .saleId(entity.getSaleId())
                .saleValue(entity.getSaleValue())
                .saleDateTime(entity.getSaleDateTime())
                .saleStatus(entity.getSaleStatus())
                .customerSale(getCustomerDTO(entity))
                .titlesSale(getTitleDTOS(entity))
                .build();
    }

    private static CustomerOutDTO getCustomerDTO(SaleEntity entity) {
        return CustomerOutDTO.builder()
                .customerId(entity.getCustomerEntity().getCustomerId())
                .documentId(entity.getCustomerEntity().getCustomerDocumentId())
                .customerName(entity.getCustomerEntity().getCustomerName())
                .customerType(entity.getCustomerEntity().getCustomerType())
                .build();
    }

    private static List<TitleOutDTO> getTitleDTOS(SaleEntity entity) {
        List<TitleOutDTO> titlesDTO = new ArrayList<>();
        List<TitleEntity> titlesEntity = entity.getTitleEntity();
        titlesEntity.forEach(title -> {
            titlesDTO.add(
                    TitleOutDTO.builder()
                            .titleId(title.getTitleId())
                            .titleSaleId(title.getTitleSaleId())
                            .titleCustomerId(title.getTitleCustomerId())
                            .titleDateTime(title.getTitleDateTime())
                            .titleDueDate(title.getTitleDueDate())
                            .titleValue(title.getTitleValue())
                            .titleType(title.getTitleType())
                            .titleStatus(title.getTitleStatus())
                            .build());
        });
        return titlesDTO;
    }
}