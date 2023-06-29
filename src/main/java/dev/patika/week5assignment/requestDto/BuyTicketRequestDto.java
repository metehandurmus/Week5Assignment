package dev.patika.week5assignment.requestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record BuyTicketRequestDto(@NotNull(message = "Bir koltuk seçmelisiniz.")
                                  Long chair_id,
                                  @NotNull(message = "Telefon numarası parametresini girmediniz.")
                                  @NotBlank(message = "Telefon numarası boş olamaz.")
                                  String phone) {
}
