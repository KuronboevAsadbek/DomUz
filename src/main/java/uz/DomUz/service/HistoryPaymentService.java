package uz.DomUz.service;

import uz.DomUz.model.HistoryPayment;

import java.util.List;

public interface HistoryPaymentService {

    HistoryPayment addHistoryPayment(HistoryPayment historyPayment);

    List<HistoryPayment> getAllHistoryPayment();

    void delete(Long id);

    HistoryPayment update(HistoryPayment historyPayment);

    //sum of all history payment by account id

    String sumAllHistoryPaymentByAccountId(Long id);


}
