package net.skhu.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.skhu.domain.entity.Rent;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class RentDto {
	private Long rent_id;
	private String author;
	private String rent_title;
	private String rent_content;
	private String picture;
	private String price;
	private LocalDateTime rent_date;
    private String rent_kind;

	public Rent toEntity() {
		Rent build = Rent.builder()
				.rent_id(rent_id)
				.author(author)
				.rent_title(rent_title)
				.rent_content(rent_content)
				.picture(picture)

				.build();

		return build;
	}

	@Builder
	public RentDto(Long rent_id, String author, String rent_title, String rent_content, String picture, LocalDateTime rent_date
			) {
		this.rent_id = rent_id;
		this.author = author;
		this.rent_title = rent_title;
		this.rent_content = rent_content;
		this.rent_date = rent_date;
		this.picture = picture;

	}

}
