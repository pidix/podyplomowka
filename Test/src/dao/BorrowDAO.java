package dao;

import model.Borrow;

public interface BorrowDAO extends GenericDAO<Borrow> {

	public Borrow findById(long userId, long bookId);
}
