/*
 * Auteurs : Alexandre Monteiro Marques, Alison Savary
 *
 * Cours : RES
 * Laboratoire : SMTP
 *
 * Date : 1 Avril 2019
 *
 */

package model.mail;

public class Mail {
    private String from = null;
    private String[] to = null;
    private String[] cc = null;
    private String[] bcc = null;
    private String subject = null;
    private String message = null;

    /**
     * Retourne l'expéditeur du mail
     * @return adresse mail de l'expéditeur
     */
    public String getFrom() {
        return from;
    }

    /**
     * Retourne les destinataires
     * @return adresses mail des destinataires
     */
    public String[] getTo() {
        return to;
    }

    /**
     * Retourne les destinataires en copie
     * @return adresses des destinataires en copie
     */
    public String[] getCc() {
        return cc;
    }

    /**
     * Retourne les destinataires en copie cachée
     * @return adresses des destinataires en copie cachée
     */
    public String[] getBcc() {
        return bcc;
    }

    /**
     * Retourne le sujet du mail
     * @return Sujet
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Retourne le message du mail
     * @return corps du message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Definit l'expéditeur du mail
     * @param from l'expéditeur du mail
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Definit les destinaires du mail
     * @param to les destinataires du mail
     */
    public void setTo(String[] to) {
        this.to = to;
    }

    /**
     * Definit les destinaires en copie du mail
     * @param cc des destinataires de copie du mail
     */
    public void setCc(String[] cc) {
        this.cc = cc;
    }

    /**
     * Definit les destinataire en copie cachée du mail
     * @param bcc des destinataires de copie cachée du mail
     */
    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    /**
     * Definit le sujet du mail
     * @param subject le sujet du mail
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Definit le message du mail
     * @param message corps du mail
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
