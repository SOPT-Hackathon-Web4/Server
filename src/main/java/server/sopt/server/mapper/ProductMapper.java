package server.sopt.server.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    //    ProductMapper INSTNACE = Mappers.getMapper(ProductMapper.class)
//    @Mapping(target = "productId", source = "id")
//    @Mapping(target = "customerId", source = "product.customer.id")
//    ProductFindDto toProductFindDto(Product product);
}
