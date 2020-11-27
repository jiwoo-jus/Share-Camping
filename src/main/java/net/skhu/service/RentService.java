package net.skhu.service;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import net.skhu.domain.entity.Rent;
import net.skhu.domain.repository.RentRepository;
import net.skhu.dto.RentDto;


@Getter
@Setter
@Service
public class RentService {
	private RentRepository rentRepository;

	public RentService(RentRepository rentRepository) {
		this.rentRepository = rentRepository;
	}

	@Transactional
	public Long savePost(RentDto rentDto) {
		return rentRepository.save(rentDto.toEntity()).getRent_id();
	}

	@Transactional
    public List<RentDto> getRentList() {
        List<Rent> rentList = rentRepository.findAll();
        List<RentDto> rentDtoList = new ArrayList<>();

        for(Rent rent : rentList) {
            RentDto rentDto = RentDto.builder()
                    .rent_id(rent.getRent_id())
                    .author(rent.getAuthor())
                    .rent_title(rent.getRent_title())
                    .rent_content(rent.getRent_content())
                    .rent_date(rent.getRent_date())
                    .picture(rent.getPicture())

                    .build();
            rentDtoList.add(rentDto);
        }
        return rentDtoList;
    }

	@Transactional
	public RentDto getRentPost(Long rent_id) {
		Rent rent = rentRepository.findById(rent_id).get();

		RentDto rentDto = RentDto.builder()
				.rent_id(rent.getRent_id())
				.author(rent.getAuthor())
				.rent_title(rent.getRent_title())
				.rent_content(rent.getRent_content())
				.rent_date(rent.getRent_date())
				.picture(rent.getPicture())

				.build();
		return rentDto;
	}

	@Transactional
    public void deleteRentPost(Long rent_id) {
        rentRepository.deleteById(rent_id);
    }
}
