package uz.DomUz.service.imp;

import org.springframework.stereotype.Service;
import uz.DomUz.model.HistoryPayment;
import uz.DomUz.repository.HistoryPaymentRepository;
import uz.DomUz.service.HistoryPaymentService;

import java.util.List;

@Service
public class HistoryPaymentServiceImp implements HistoryPaymentService {
    private final HistoryPaymentRepository historyPaymentRepository;

    public HistoryPaymentServiceImp(HistoryPaymentRepository historyPaymentRepository) {
        this.historyPaymentRepository = historyPaymentRepository;
    }


    @Override
    public HistoryPayment addHistoryPayment(HistoryPayment historyPayment) {
        return historyPaymentRepository.save(historyPayment);
    }

    @Override
    public List<HistoryPayment> getAllHistoryPayment() {
        return historyPaymentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        historyPaymentRepository.deleteById(id);
    }

    @Override
    public HistoryPayment update(HistoryPayment historyPayment) {
        HistoryPayment historyPayment1 = historyPaymentRepository.findById(historyPayment.getId()).get();
        if (historyPayment.getPayment() != null) {
            historyPayment1.setPayment(historyPayment.getPayment());
        }
        if (historyPayment.getDate() != null) {
            historyPayment1.setDate(historyPayment.getDate());
        }
        if (historyPayment.getDescription() != null) {
            historyPayment1.setDescription(historyPayment.getDescription());
        }
        return historyPaymentRepository.save(historyPayment1);
    }

    @Override
    public String sumAllHistoryPaymentByAccountId(Long id) {
        List<HistoryPayment> historyPaymentList = historyPaymentRepository.findAll();
        double sum = 0;
        for (HistoryPayment historyPayment : historyPaymentList) {
            if (historyPayment.getAccount().getId() == id) {
                sum += Double.parseDouble(historyPayment.getPayment());
            }else System.out.println("Account not found");
        }
        return String.valueOf(sum);
    }
}
