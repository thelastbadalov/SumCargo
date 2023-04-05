package az.sum.service;

import az.sum.dto.CourierDto;
import az.sum.dto.CreateCourierRequest;
import az.sum.dto.converter.CourierDtoConverter;
import az.sum.exception.CoruierNotFoundException;
import az.sum.model.Courier;
import az.sum.model.CourierStatus;
import az.sum.model.Role;
import az.sum.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierService {
    private final CourierRepository courierRepository;
    private final CourierDtoConverter dtoConverter;

    public CourierDto createCourier(CreateCourierRequest request) {
        Courier courier = new Courier(
                request.getMail(),
                request.getFirstName(),
                request.getLastName(),
                request.getPassword(),
                Role.COURIER,
                request.getStatus());

        return dtoConverter.convertToDto(courierRepository.save(courier));
    }

    public void changeCourierStatus(String mail) {
        Courier courier = findCourierByMail(mail);
        courier.setStatus(CourierStatus.OCCUPIED);
        dtoConverter.convertToDto(courier);
    }

    public List<CourierDto> getAllCouriers() {
        return dtoConverter.convert(courierRepository.findAll());
    }


    protected Courier findCourierByMail(String mail) {
        return courierRepository.findByMail(mail)
                .orElseThrow(() -> new CoruierNotFoundException("can not find courier with given mail " + mail));
    }
}
