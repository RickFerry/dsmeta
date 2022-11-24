package br.com.ferry.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import br.com.ferry.dsmeta.entities.Sale;
import br.com.ferry.dsmeta.repositories.SaleRepository;
import lombok.AllArgsConstructor;

@Service
public class SmsService {

    @Autowired
    private SaleRepository saleRepository;

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;
    
    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    public void sendSms(Long id) throws NotFoundException {
        String msg = msgMount(id);
        
        Twilio.init(twilioSid, twilioKey);
        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
        Message message = Message.creator(to, from, msg).create();
        System.out.println(message.getSid());
    }

    private String msgMount(Long id) throws NotFoundException {
        Sale sale = saleRepository.findById(id)
                                  .orElseThrow(NotFoundException::new);

        String date = sale.getDate().getMonthValue()
        + "/" + sale.getDate().getYear();

        return "O vendedor " + sale.getSellerName()
                     + " foi destaque em " + date + " com um total de R$ "
                     + String.format("%.2f", sale.getAmount());
    }
}
