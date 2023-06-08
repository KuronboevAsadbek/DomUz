package uz.DomUz.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import uz.DomUz.exception.NotFoundException;
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
        try {
            historyPaymentRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException("History Not Found");
        }
    }

    @Override
    public HistoryPayment update(HistoryPayment historyPayment) {
        if (ObjectUtils.isEmpty(historyPayment.getId())) {
            throw new NotFoundException("History Not Found");
        }
        return historyPaymentRepository.save(historyPayment);
    }

    @Override
    public String sumAllHistoryPaymentByAccountId(Long id) {
        double sum = historyPaymentRepository.findAll().stream()
                .filter(historyPayment -> historyPayment.getAccount().getId().equals(id))
                .mapToDouble(historyPayment -> Double.parseDouble(historyPayment.getPayment()))
                .sum();
        return String.valueOf(sum);
    }
}
