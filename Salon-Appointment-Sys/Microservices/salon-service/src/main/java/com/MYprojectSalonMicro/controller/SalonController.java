package com.MYprojectSalonMicro.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MYprojectSalonMicro.mapper.SalonMapper;
import com.MYprojectSalonMicro.modal.Salon;
import com.MYprojectSalonMicro.payload.dto.SalonDTO;
import com.MYprojectSalonMicro.payload.dto.UserDTO;
import com.MYprojectSalonMicro.service.SalonService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController

@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SalonController {
    
  private final  SalonService salonService;
// localhost:5002/api/salons
@PostMapping
  public ResponseEntity<SalonDTO> createSalon(@RequestBody  SalonDTO salonDTO) {
  UserDTO userDTO = new UserDTO();
  userDTO.setId(1L);
    Salon salon = salonService.createSalon(salonDTO,userDTO);
    SalonDTO salonDTO1 = SalonMapper.mapToDTO(salon);
    return ResponseEntity.ok(salonDTO1);
  }
//update salon
@PatchMapping("/{id}")
  public ResponseEntity<SalonDTO> updateSalon(
    @PathVariable("id") Long salonId,
    @RequestBody  SalonDTO salonDTO) throws Exception {
    UserDTO userDTO = new UserDTO();
    userDTO.setId(1L);

      Salon salon = salonService.updateSalon(salonDTO,userDTO,salonId);
      SalonDTO salonDTO1 = SalonMapper.mapToDTO(salon);
      return ResponseEntity.ok(salonDTO1);
    }

    @GetMapping
  public ResponseEntity<List<SalonDTO>> getSalons() throws Exception {
   
      List<Salon> salons = salonService.getAllSalons();

     List<SalonDTO> salonDTOS = salons.stream().map((salon)->

     {SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
        return salonDTO;
        }).toList();
        return ResponseEntity.ok(salonDTOS);
    }

//get salon by id
    @GetMapping("/{salonId}")
    public ResponseEntity<SalonDTO> getSalonsById(
        @PathVariable Long salonId
        )throws Exception {
 
       Salon salon= salonService.getSalonById(salonId);
         SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
         return ResponseEntity.ok(salonDTO);
      }
//searching salon here
      @GetMapping("/search")
      public ResponseEntity<List<SalonDTO>> searchSalons(
        @RequestParam("city") String city)
         throws Exception {
       
        List <Salon> salons = salonService.searchSalonByCity(city);
         List<SalonDTO> salonDTOS = salons.stream().map((salon)->
         {SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
            return salonDTO;
            }).toList();
            return ResponseEntity.ok(salonDTOS);
        }
    


        @GetMapping("/owner")
        public ResponseEntity<SalonDTO> getSalonsByOwnerId(
            @PathVariable Long salonId)
              throws Exception {
          UserDTO userDTO = new UserDTO();
          userDTO.setId(1L);

           Salon salon= salonService.getSalonByOwnerId(userDTO.getId());
           
             SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
             return ResponseEntity.ok(salonDTO);
          }
}
