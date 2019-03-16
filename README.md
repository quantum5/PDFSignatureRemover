# PDFSignatureRemover [![](https://img.shields.io/jenkins/s/https/ci.dmoj.ca/job/PDFSignatureRemover.svg)](https://ci.dmoj.ca/job/PDFSignatureRemover/)

Sometimes, you have to open signed PDF files. Digital signature is good
and everything, but it leaves an annoying warning if the signature fails
to verify. If you are using Adobe Reader, every time you open the file, it
complains that the signature is invalid.

`PDFSignatureRemover` is a tool that can remove the pesky signatures for you.

## Usage

```
$ wget https://ci.dmoj.ca/job/PDFSignatureRemover/lastSuccessfulBuild/artifact/target/PDFSignatureRemover-1.0-SNAPSHOT.jar -O PDFSignatureRemover.jar
$ java -jar PDFSignatureRemover.jar signed.pdf output.pdf
```

This will convert `signed.pdf`, with a PDF signature, to `output.pdf`,
without the signature.
