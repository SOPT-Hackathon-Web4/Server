package server.sopt.server.mapper;

import org.mapstruct.Mapper;
import server.sopt.carrot.dto.customer.CustomerFindDto;
import server.sopt.carrot.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
//    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
//    @Mapping()
    CustomerFindDto toCustomerDto(Customer customer);
}
