
package br.com.jansoftinfo.apiteste.adapter.out.mappers;

import br.com.jansoftinfo.apiteste.adapter.out.dtos.*;
import br.com.jansoftinfo.apiteste.domain.entities.SaleEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaleOutMapper {

    public List<SaleOutResumeDTO> toDTOResume(List<SaleEntity> entities) {
        var salesDTO = new ArrayList<SaleOutResumeDTO>();
        entities.forEach(sale -> {
            salesDTO.add(getSaleResume(sale));
        });
        return salesDTO;
    }

    public List<SaleOutDTO> toDTO(List<SaleEntity> entities) {
        var salesDTO = new ArrayList<SaleOutDTO>();
        entities.forEach(sale -> {
            salesDTO.add(getSale(sale));
        });
        return salesDTO;
    }

    public SaleOutDTO toDTO(SaleEntity entity) {
        return getSale(entity);
    }

    private static SaleOutDTO getSale(SaleEntity entity) {
        return new SaleOutDTO(
            entity.getSaleId(),
            entity.getSaleValue(),
            entity.getSaleDateTime(),
            entity.getSaleStatus(),
            getCustomerDTO(entity),
            getProductDTOS(entity),
            getTitleDTOS(entity)
        );
    }

    private static SaleOutResumeDTO getSaleResume(SaleEntity entity) {
        return new SaleOutResumeDTO(
            entity.getSaleId(),
            entity.getSaleValue(),
            entity.getSaleDateTime(),
            entity.getSaleStatus(),
            getCustomerDTO(entity).nome_cliente(),
            getProductDTOS(entity)
        );
    }

    private static CustomerOutDTO getCustomerDTO(SaleEntity entity) {
        return new CustomerOutDTO(
            entity.getCustomer().getCustomerId(),
            entity.getCustomer().getCustomerDocumentId(),
            entity.getCustomer().getCustomerName(),
            entity.getCustomer().getCustomerType()
        );
    }

    private static List<ProductOutDTO> getProductDTOS(SaleEntity entity) {
        var products = new ArrayList<ProductOutDTO>();
        entity.getProducts().forEach(product -> {
            products.add(
                new ProductOutDTO(
                    product.getProductId(),
                    product.getProductDescription(),
                    product.getProductUnity(),
                    product.getProductValue()
                )
            );
        });
        return products;
    }

    private static List<TitleOutDTO> getTitleDTOS(SaleEntity entity) {
        var titles = new ArrayList<TitleOutDTO>();
        entity.getTitles().forEach(title -> {
            titles.add(
                new TitleOutDTO(
                    title.getTitleId(),
                    title.getTitleDateTime(),
                    title.getTitleDueDate(),
                    title.getTitleValue(),
                    title.getTitleType(),
                    title.getTitleStatus()
                )
            );
        });
        return titles;
    }
}